package ru.english.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.english.entity.Words;
import ru.english.repository.WordsRepo;

import java.util.List;

@Service
public class MainService {

    private final WordsRepo wordsRepo;
    @Autowired
    public MainService(WordsRepo wordsRepo) {
        this.wordsRepo = wordsRepo;
    }

    public List<Words> getAll() {
        return wordsRepo.getRandomWords();
    }

    public void insertListWord(List<Words> wordsList) {
        wordsRepo.insertListWords(wordsList);
    }

}
