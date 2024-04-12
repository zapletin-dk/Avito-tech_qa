> [!CAUTION]
>1. В названии лейбла ошибка. Название компании "**Avito**", в название лейбла на странице указано "**Awito**".
<p align="center">
 <img width="200px" src="/images/Awito.jpg" alt="First bug"/>
</p>

> [!NOTE]
>2. В строке шорткатов перехода по дереву поиска товара нет последней ветки поиска. Пользователь ищет телефон марки **Samsung**.
<p align="center">
 <img width="400px" src="/images/Finder_path_tree.jpg" alt="Second bug"/>
</p> 

> [!NOTE]
>3. В строке шорткатов перехода по дереву поиска товара ветки поиска начинаются с маленькой буквы.
<p align="center">
 <img width="400px" src="/images/Finder_path_tree.jpg" alt="Third bug"/>
</p>

> [!NOTE]
>4. Выбранный режима выдачи товаров на экране (иконка) не отличается от остальных режимов, что можем ввести в заблуждение пользователя.
<p align="center">
 <img width="100px" src="/images/Deceptive_toolbar.jpg" alt="Fourth bug"/>
</p>

> [!CAUTION]
>5. Отсутствует флажок выбора для функции "_Сначала из Москвы_".
<p align="center">
 <img width="200px" src="/images/City_toggle_switch.jpg" alt="Fifth bug"/>
</p>

> [!NOTE]
>6. Результат выдачи не соответствует запросу исходя из изображения товара. Пользователь ищет телефон марки **Samsung**, в результате выдачи телефон марки **Iphone**. <br />***Low приоритет***, так как я считаю это ошибкой модерации. Если же существует алгоритм автоматической модерации, то приоритет ***High*** из-за неправильно работы бизнес процессов.
<p align="center">
 <img width="200px" src="/images/Phone_model_mismatch.jpg" alt="Sixfth bug"/>
</p>

> [!WARNING]
>7. В боковой панели фильтрации товара отсутствует возможность выбрать размер оперативной памяти устройства, хотя в выдаче товаров указывается оперативная память устройств.

> [!NOTE]
>8. Цвет устройства на картинке в выдаче не соответствует цвету устройства, заданного фильтром. Ожидаемый цвет - _синий_, актуальный - _зеленый_.<br /> Приоритет **LOW**. Однако если существует алгоритм распознавания цветов или модерация, то приоритет **MEDIUM**.
<p align="center">
 <img width="200px" src="/images/Colour_and_price_output_mismatch.jpg" alt="Eighth bug"/>
</p>

> [!NOTE]
> 9. Стоимость устройства на картинке в выдаче не соответствует заданному ценовому диапазону. Ожидаемая цена - до **50000 р**., актуальная - **59999 р**.
<p align="center">
 <img width="200px" src="/images/Colour_and_price_output_mismatch.jpg" alt="Ninth bug"/>
</p>

> [!NOTE]
> 10. В описании технических характеристик товара текст не соответствует общему шаблону. В шаблоне **"ГБ"**, в выдаче **"Гб"**.
<p align="center">
 <img width="200px" src="/images/Colour_and_price_output_mismatch.jpg" alt="Tenth bug"/>
</p>

> [!NOTE]
> 11. Цвет устройства на картинке в выдаче не соответствует цвету устройства, заданного фильтром. Ожидаемый цвет - _синий_, актуальный - _черный_.<br /> Приоритет **LOW**. Однако если существует алгоритм распознавания цветов или модерация, то приоритет **MEDIUM**.
<p align="center">
 <img width="200px" src="/images/Colour_and_memory_capacity_mismatch.jpg" alt="Eleventh bug"/>
</p>

> [!NOTE]
>12. Текст описания устройства не соответствует заданному шаблону: величина шрифта меньше и технические характеристики устройства отображаются в одну строчку с названием устройства.
<p align="center">
 <img width="200px" src="/images/Colour_and_memory_capacity_mismatch.jpg" alt="Twelfth bug"/>
</p>

> [!CAUTION]
>13. Размер внутренней памяти устройства не соответствует заданному фильтру. Ожидаемы результат - **512 ГБ**, актуальный - **256 ГБ**.
<p align="center">
 <img width="200px" src="/images/Colour_and_memory_capacity_mismatch.jpg" alt="Thirteenth bug"/>
</p>

> [!CAUTION]
>14. Результат выдачи не соответствует запросу исходя из фильтрации по производителю устройства. Пользователь ищет телефон марки **Samsung**, в результате выдачи телефон марки **Iphone**.
<p align="center">
 <img width="200px" src="/images/Phone_model_mismatch.jpg" alt="Fourteenth bug"/>
</p>

> [!NOTE]
>15. Текст описания устройства не соответствует заданному шаблону: технические характеристики устройства отображаются в одну строчку с названием устройства, в шаблоне **"ГБ"**, в выдаче **"Гб"**.
<p align="center">
 <img width="200px" src="/images/Phone_model_mismatch.jpg" alt="[Fifteenth bug]"/>
</p>

> [!WARNING]
>16. Лексическая ошибка в тексте. Следует заменить _"Требует ремонт"_ на _"Требуется ремонт"_ или _"Требует ремонта"_.
<p align="center"> 
 <img width="200px" src="/images/Lexical_error.jpg" alt="[Sixteenth bug]"/>
</p>

> [!NOTE]
>17. Несоответсвие шаблону описания местонахождения товара. Отсутствует город нахождения **"Москва"**.
<p align="center">
 <img width="200px" src="/images/City_name_missed.jpg" alt="[Seventeenth bug]"/>
</p>

> [!CAUTION]
>18. Несоответствие отображения количества найденного товара. Ожидаемый результат - **119989**, актуальный - **77**.
<p align="center">
 <img width="200px" src="/images/Item_counter_mismatch.jpg" alt="[Eighteenth bug]"/>
</p>

> [!CAUTION]
>19. Указан несуществующий Административный\географический объект _"Соколдо"_.
<p align="center">
 <img width="200px" src="/images/Defunct_geographic_feature.jpg" alt="[Nineteenth bug]"/>
</p>

> [!NOTE]
>20. В тексте заголовка отсутствует название производителя устройства, при условии, что плейсхолдер производителя заполнен. *"Смартфоны и мобильные телефоны **Samsung** в Москве"*.
<p align="center">
 <img width="200px" src="/images/Header_issue.jpg" alt="[Twentieth bug]"/>
</p>

> [!WARNING]
>21. Цвет текста в плейсхолдере производителя не явно отображает выбор. Следует изменить стиль шрифта на более понятный, например **"Samsung"**.
<p align="center">
 <img width="200px" src="/images/Manufacturer_placeholder.jpg" alt="[Twenty-first bug]"/>
</p>

> [!NOTE]
>22. Футер подразумевает, что контент страницы закончился. В случае скриншота - не все товары были просмотрены, однако футер на скриншоте присутствует.

> [!NOTE]
>23. Ошибка шаблона отображения адреса, следует вывести в одну строчку "Москва, ул. Большая Тульская".
<p align="center">
 <img width="200px" src="/images/Adress_template_issue.jpg" alt="[Twenty-third bug]"/>
</p>

   
