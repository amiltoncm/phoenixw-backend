package br.com.amxsistemas.phoenix.utils.messages;

import br.com.amxsistemas.phoenix.utils.language.Language;

public class Messages {

    public static String getMessage(int messageCode) {
        return getMessageCode(Language.getLanguage(), messageCode);
    }

    public static String getMessageCode(String language, int messageCode) {

        if (language.equals("PT-BR")) {
            return switch (messageCode) {
                case 1 -> "Erro genérico!";
                case 2 -> "Objeto não encontrado!";
                case 3 -> "Erro ao gravar lista!";
                case 4 -> "Lista adicionada com sucesso!";
                case 5 -> "Usuário não encontrado!";
                default -> "Erro genérico!";
            };
        }

        if (language.equals("US-EN")) {
            return switch (messageCode) {
                case 1 -> "Generic error!";
                case 2 -> "Object not found!";
                case 3 -> "Error on post list!";
                case 4 -> "List added with success!";
                case 5 -> "User not found!";
                default -> "Generic error!";
            };
        }

        return "Generic error!";
    }

}
