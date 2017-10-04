package br.com.digidev.messenger4j.send.buttons;

import java.util.Objects;

/**
 * @author Messenger4J - http://github.com/messenger4j
 */
abstract class TitleButton extends Button {

    private final String title;

    TitleButton(ButtonType type, String title) {
        super(type);
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        TitleButton that = (TitleButton) o;
        return Objects.equals(title, that.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), title);
    }

    @Override
    public String toString() {
        return "TitleButton{" +
                "title='" + title + '\'' +
                "} super=" + super.toString();
    }
}
