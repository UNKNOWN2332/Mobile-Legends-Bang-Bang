package com.mycompany.myapp.service.telegram;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;

@Component
public class MessageControl {

    public SendMessage messageControl(String text, Long chatId, Integer messageId) {
        SendMessage sendMessage = new SendMessage();

        sendMessage.setChatId(String.valueOf(chatId));
        if (text.equals("/start")) {
            sendMessage.setText(
                "\uD83C\uDDFA\uD83C\uDDFFAssalomu Alaykum | \uD83C\uDDFA\uD83C\uDDF8Hello | \uD83C\uDDF7\uD83C\uDDFAЗдраствуйте\n" +
                "_Tilni tanlag_ |  _Select the language_ |  _ Веберите язык_"
            );
            sendMessage.setParseMode("Markdown");

            sendMessage.setReplyMarkup(
                InlineButtonUtil.keyboard(
                    InlineButtonUtil.collection(
                        InlineButtonUtil.rows(
                            InlineButtonUtil.button("\uD83C\uDDFA\uD83C\uDDFFO'zbek", "uzb"),
                            InlineButtonUtil.button("\uD83C\uDDFA\uD83C\uDDF8English", "eng"),
                            InlineButtonUtil.button("\uD83C\uDDF7\uD83C\uDDFAРуссий", "rus")
                        )
                    )
                )
            );
        }
        return sendMessage;
    }
}
