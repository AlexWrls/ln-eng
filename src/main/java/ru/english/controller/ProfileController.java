package ru.english.controller;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.english.entity.Words;
import ru.english.service.MainService;

import java.util.ArrayList;
import java.util.List;


@Controller
public class ProfileController {

    private final MainService mainService;

    @Autowired
    public ProfileController(MainService profileService) {
        this.mainService = profileService;
    }

    @GetMapping("/")
    public String english(Model model) {
        List<Words> words = mainService.getAll();
        model.addAttribute("title", "English");
        model.addAttribute("words", words);
        return "english";
    }


//    @GetMapping("/parse")
//    public String parse() {
//        try {
//            List<Words> wordsList = new ArrayList<>();
//            Document doc = Jsoup.connect("https://studynow.ru/dicta/allwords").get();
//            Element element = doc.getElementById("wordlist");
//            for (int i = 0; i < 5000; i++) {
//                Words word = new Words();
//                Node w = element.child(0).child(i).child(1).childNode(0);
//                word.setWord(w.toString());
//                Node t = element.child(0).child(i).child(2).childNode(0);
//                word.setTranslate(t.toString());
//                wordsList.add(word);
//            }
//            mainService.insertListWord(wordsList);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return "redirect:/main";
//    }

}
