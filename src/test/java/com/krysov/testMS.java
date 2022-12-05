package com.krysov;

import com.codeborne.selenide.CollectionCondition;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.List;
import java.util.stream.Stream;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class testMS{
    @BeforeAll
    static void setUp() {
        open("https://www.sportmaster.ru/");}
    static Stream<Arguments> sportMaster(){
        return Stream.of(
                Arguments.of("ВИДЫ СПОРТА", List.of(
                        "КАТАЛОГ\n" +
                        "ЖЕНЩИНАМ\n" +
                        "МУЖЧИНАМ\n" +
                        "ДЕТЯМ\n" +
                        "ВИДЫ СПОРТА\n" +
                        "БРЕНДЫ\n" +
                        "PREMIUM\n" +
                        "РАСПРОДАЖА\n" +
                        "АКЦИИ\n" +
                        "МЕДИА")),
                Arguments.of("БРЕНДЫ", List.of(
                        "КАТАЛОГ\n" +
                        "ЖЕНЩИНАМ\n" +
                        "МУЖЧИНАМ\n" +
                        "ДЕТЯМ\n" +
                        "ВИДЫ СПОРТА\n" +
                        "БРЕНДЫ\n" +
                        "PREMIUM\n" +
                        "РАСПРОДАЖА\n" +
                        "АКЦИИ\n" +
                        "МЕДИА"))
        );
    }

    @MethodSource
    @ParameterizedTest(name = "Отображение списка горизонтального меню  {1} " + ", на странице  {0}")
    @Tag("Critical")
    void sportMaster(String appliances,List<String> filter) {
        $(".sm-header__catalog").$(byText(appliances)).click();
        $$(".sm-header__catalog").filter(visible).shouldHave(CollectionCondition.texts(filter));
    }
}
