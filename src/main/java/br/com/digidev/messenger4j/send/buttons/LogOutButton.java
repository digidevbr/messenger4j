package br.com.digidev.messenger4j.send.buttons;

/**
 * @author Messenger4J - http://github.com/messenger4j
 * @since 0.7.0
 */
public final class LogOutButton extends Button {

    private LogOutButton() {
        super(ButtonType.ACCOUNT_UNLINK);
    }

    @Override
    public boolean isLogOutButton() {
        return true;
    }

    @Override
    public LogOutButton asLogOutButton() {
        return this;
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public String toString() {
        return "LogOutButton{} super=" + super.toString();
    }

    /**
     * @author Messenger4J - http://github.com/messenger4j
     * @since 0.7.0
     */
    public static final class Builder {

        private final ListBuilder listBuilder;

        Builder(ListBuilder listBuilder) {
            this.listBuilder = listBuilder;
        }

        public ListBuilder toList() {
            return this.listBuilder.addButtonToList(new LogOutButton());
        }
    }
}