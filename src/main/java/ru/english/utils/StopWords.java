package ru.english.utils;

import ru.english.entity.Words;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum StopWords {

            MORON("moron"),
            FUCK("fuck"),
            CRAP("crap"),
            WHORE("whore"),
            SLUT("slut"),
            DOUCHEBAG("douchebag"),
            FAGGOT("faggot"),
            HOMO("homo"),
            BASTARD("bastard"),
            ASSHOLE("asshole"),
            JERK("jerk"),
            PRICK("prick"),
            DICK("dick"),
            CUNT("cunt"),
            PUSSY("pussy"),
            SUCKER("sucker"),
            NERD("nerd"),
            DUMB("dumb"),
            FOOL("fool"),
            STUPID("stupid"),
            RETARD("retard"),
            BITCH("bitch"),
    ;
            
   private final String name;
    public String getName() {
        return name;
    }
    StopWords(String name) {
        this.name = name;
    }

    public static List<Words> filterStopWords(List<Words> words){
        List<String> stopWords = Arrays.stream(StopWords.values())
                .map(StopWords::getName)
                .collect(Collectors.toList());
       return words.stream()
               .filter(w->!stopWords.contains(w.getWord()))
               .collect(Collectors.toList());
    }
}
