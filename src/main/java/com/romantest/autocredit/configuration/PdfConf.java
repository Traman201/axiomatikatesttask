package com.romantest.autocredit.configuration;

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.pdf.BaseFont;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;

@Configuration
public class PdfConf {

    @Bean
    public Font getFont(){
        final String FONT = "fonts/Arial Unicode.ttf";

        BaseFont bf= null;
        try {
            bf = BaseFont.createFont(FONT, "cp1251", BaseFont.EMBEDDED);
        } catch (DocumentException | IOException e) {
            throw new RuntimeException(e);
        }
        Font font=new Font(bf,20 ,Font.NORMAL);
        return font;
    }
}
