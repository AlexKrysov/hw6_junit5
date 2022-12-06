package com.krysov;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class TestCsvS extends TestBase{

    @CsvSource({
            "шапки, Выбрать магазин",
            "кроссовки, Бренд",
            "куртки, Пол"
    })

    @ParameterizedTest(name = "Проверка отображения боковового меню {1} " + ", при поиске товара {0}")
    @Tag("Critical")
    void sportMasterTest(String searchProducts, String expectProducts) {
        $("[placeholder='Поиск']").setValue(searchProducts).pressEnter();
        $(".sm-facets-list").shouldHave(text(expectProducts));
    }
}
