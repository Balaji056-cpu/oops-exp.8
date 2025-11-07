package oopsexp8og;

import java.util.Scanner;

class WordTask implements Runnable {
    private final String paragraph;
    WordTask(String paragraph) { this.paragraph = paragraph; }

    public void run() {
        String[] words = paragraph.trim().split("\\s+");
        for (String w : words) {
            System.out.println("[word]  " + w);
            try { Thread.sleep(2000); } catch (InterruptedException ignored) {}
        }
    }
}

class VowelTask implements Runnable {
    private final String paragraph;
    VowelTask(String paragraph) { this.paragraph = paragraph; }

    public void run() {
        String vowels = "aeiouAEIOU";
        for (char c : paragraph.toCharArray()) {
            if (vowels.indexOf(c) >= 0) {
                System.out.println("[vowel] " + c);
                try { Thread.sleep(2000); } catch (InterruptedException ignored) {}
            }
        }
    }
}

public class RunnableDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter paragraph:");
        String para = sc.nextLine();

        Thread word = new Thread(new WordTask(para), "word");
        Thread vowel = new Thread(new VowelTask(para), "vowel");

        word.start();
        vowel.start();
    }
}
