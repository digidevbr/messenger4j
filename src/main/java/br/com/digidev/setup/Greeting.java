package br.com.digidev.setup;

/**
 * @author Andriy Koretskyy
 * @since 0.8.0
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
