package br.com.amxsistemas.phoenix.utils;

public class Messages {

    public static String getMessage(String type) {

        String language = Language.getLanguage();

        if (type.equals("OBJECTNOTFOUND")) {
            if (language.equals("PT-BR")) {
                return "Objeto não encontrado!";
            }
            if (language.equals("US-EN")) {
                return "Object not found!";
            }
        }

        String genericError = "Erro genérico!";
        if (language.equals("US-EN")) {
            genericError = "Generic error!";
        }
        return genericError;
    }

    public static String getMsgResult(int messageCode, String defaultMsg) {
        return switch (messageCode) {
            case 0 -> "Error on post list!";
            case 1 -> "List added with success!";
            default -> defaultMsg;
        };
    }
}
