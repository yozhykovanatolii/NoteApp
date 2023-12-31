package com.example.myapplication.noteapp.utils;

public class TextConverter {
    private String text;

    public String getText(String oldText) {
        if(oldText.contains("\n")){
            int index = oldText.indexOf('\n');
            text = oldText.substring(0, index);
        }else{
            text = oldText;
        }
        return text;
    }
}
