package ru.english.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.english.entity.Words;
import ru.english.repository.WordsRepo;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@Service
public class MainService {

    private static List<String> stopWords = new ArrayList<>();
    Logger log = Logger.getLogger(Logger.class.getName());

    @PostConstruct
    public void init() {
        try {
            URL url = ClassLoader.getSystemResource("stopword");
            Path path = Paths.get(url.toURI());
            stopWords = Files.readAllLines(path, StandardCharsets.UTF_8);
        } catch (URISyntaxException | IOException e) {
            log.log(Level.WARNING, e.getMessage());
            e.printStackTrace();
        }
    }

    private final WordsRepo wordsRepo;

    @Autowired
    public MainService(WordsRepo wordsRepo) {
        this.wordsRepo = wordsRepo;
    }

    public List<Words> getAll() {
        return wordsRepo.getRandomWords().stream()
                .filter(w -> !stopWords.contains(w))
                .collect(Collectors.toList());
    }

    public void insertListWord(List<Words> wordsList) {
        wordsRepo.insertListWords(wordsList);
    }

}
