package br.com.digidev.setup;

import br.com.digidev.internal.JsonHelper;
import com.google.gson.JsonObject;

import java.util.Objects;

/**
 * @author Andriy Koretskyy
 * @since 0.8.0
 */
public final class SetupResponse {

    private final String result;

    public static SetupResponse fromJson(JsonObject jsonObject) {
        final String result = JsonHelper.getPropertyAsString(jsonObject, JsonHelper.Constants.PROP_RESULT);
        return new SetupResponse(result);
    }

    private SetupResponse(String result) {
        this.result = result;
    }

    public String getResult() {
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SetupResponse that = (SetupResponse) o;
        return Objects.equals(result, that.result);
    }

    @Override
    public int hashCode() {
        return Objects.hash(result);
    }

    @Override
    public String toString() {
        return "SetupResponse{" +
                "result = '" + result + '\'' +
                '}';
    }
}