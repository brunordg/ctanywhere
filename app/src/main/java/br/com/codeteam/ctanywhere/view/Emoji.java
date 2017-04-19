package br.com.codeteam.ctanywhere.view;

/**
 * Created by Bruno Rodrigues e Rodrigues on 18/04/17.
 */

public class Emoji {
    
    public static String getEmojiByUnicode(int unicode){
        return new String(Character.toChars(unicode));
    }
}
