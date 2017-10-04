package br.com.digidev.messenger4j.send.templates;

import java.util.Objects;

/**
 * @author Messenger4J - http://github.com/messenger4j
 */
public abstract class Template {

    private final TemplateType templateType;

    Template(TemplateType templateType) {
        this.templateType = templateType;
    }

    public TemplateType getTemplateType() {
        return templateType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Template template = (Template) o;
        return templateType == template.templateType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(templateType);
    }

    @Override
    public String toString() {
        return "Template{" +
                "templateType=" + templateType +
                '}';
    }

    /**
     * @author Messenger4J - http://github.com/messenger4j
     */
    public enum TemplateType {

        GENERIC,
        RECEIPT,
        BUTTON,
        LIST
    }
}