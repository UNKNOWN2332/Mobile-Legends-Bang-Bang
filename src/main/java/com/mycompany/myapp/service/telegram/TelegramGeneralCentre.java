package com.mycompany.myapp.service.telegram;

import com.mycompany.myapp.config.ApplicationProperties;
import com.mycompany.myapp.service.telegram.dto.TelegramDto;
import lombok.RequiredArgsConstructor;
import org.jvnet.hk2.annotations.Service;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@Service
@RequiredArgsConstructor
public class TelegramGeneralCentre extends TelegramLongPollingBot {

    private final MessageControl messageControl;

    private final ApplicationProperties config;

    @Override
    public String getBotUsername() {
        return config.getBot().getName();
    }

    @Override
    public String getBotToken() {
        return config.getBot().getToken();
    }

    @Override
    public void onUpdateReceived(Update update) {
        Message message = update.getMessage();
        if (update.hasCallbackQuery()) {} else if (message != null) {
            if (message.isCommand()) {
                sendMsg(messageControl.messageControl(message.getText(), message.getChatId(), message.getMessageId()));
            }
        }
    }

    public void sendMsg(SendMessage sendMessage) {
        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
