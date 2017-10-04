package br.com.digidev.messenger4j.setup;

/**
 * @author Andriy Koretskyy
 */
final class Greeting {

    private final String text;

    Greeting(String greeting) {
        text = greeting;
    }

    public String getText() {
        return text;
    }
}
