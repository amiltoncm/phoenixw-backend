package br.com.amxsistemas.phoenix.utils;

public class Messages {

    public static String getMessage(int messageCode) {

        String language = Language.getLanguage();
        return getMessageCode(language, messageCode);
    }

    public static String getMessageCode(String language, int messageCode) {

        if (language.equals("PT-BR")) {
            return switch (messageCode) {
                case 1 -> "Erro genérico!";
                case 2 -> "Objeto não encontrado!";
                case 3 -> "Erro ao gravar lista!";
                case 4 -> "Lista adicionada com sucesso!";
                default -> "Erro genérico!";
            };
        }

        if (language.equals("US-EN")) {
            return switch (messageCode) {
                case 1 -> "Generic error!";
                case 2 -> "Object not found!";
                case 3 -> "Error on post list!";
                case 4 -> "List added with success!";
                default -> "Generic error!";
            };
        }

        return "Generic error!";
    }

}
