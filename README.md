# Задача

Нужно создать мобильное приложение “Пора в путешествие” с двумя экранами.

## Первый экран
Первый экран представляет из себя список актуальных дешевых авиаперелетов.

Каждая ячейка списка должна содержать:

    Город отправления.
    Город прибытия.
    Дата отправления.
    Дата возвращения.
    Цена в рублях.
    Иконка “Лайк” (имеет два состояния и означает лайкнул ли пользователь данный авиаперелет).

<img src="https://sun9-51.userapi.com/impg/h6fcHlLsy5AfrJBQ9ezaVJybbPQfQPDh4xepmA/prFfi5FDDTE.jpg?size=972x2160&quality=95&sign=95819305c054c4f25b44f64bbbd36bfb&type=album" alt="Alt text" width="243" height="540">

## Второй экран
Второй экран - это детализация перелета с кнопкой “Лайк”.
Второй экран открывается при выборе одной из ячеек первого экрана. Должна быть возможность вернуться к первому экрану назад.

Второй экран содержит данные по выбранному перелету (город отправления, город прибытия, дата отправления, дата возвращения, цена в рублях) и кнопку “Лайк”.

Кнопка лайк имеет два состояния:

    Перелет нравится.
    Перелет не нравится.

<img src="https://sun9-5.userapi.com/impg/WJG_6jITh6NKpt4kIYRs4EYC5AqJHjutx4qbWw/MdFlq3sz17Y.jpg?size=972x2160&quality=95&sign=531c015304d0b116d3a85de19526d54a&type=album" alt="Alt text" width="243" height="540">

### Примечания

1. Дизайн произвольный, на усмотрение разработчика.
2. Список авиаперелетов запрашивается один раз при старте приложения.
3. Пока происходит загрузка списка должен быть отображен индикатор загрузки.
<img src="https://sun9-13.userapi.com/impg/lVZV00jRq8heiTgHnzGpDJdHSx8E2WGpSp8Y-Q/EcxmXzeRn-w.jpg?size=972x2160&quality=95&sign=93254edeee58bce2d1326ef00044adf9&type=album" alt="Alt text" width="243" height="540">
4. Если пользователь лайкнул перелет и вернулся в список перелетов, то в списке у “лайкнутого” перелета должна “гореть” иконка “Лайк”.
5. Если пользователь “лайкнул” перелет, вышел на первый экран и еще раз зашел на второй экран, то кнопка “Лайк” должна быть в состоянии “Перелет нравится” и наоборот.
6. Апи для списка авиаперелетов:
- curl ‘[vmeste.wildberries.ru...e/GetCheap](https://vmeste.wildberries.ru/api/avia-service/twirp/aviaapijsonrpcv1.WebAviaService/GetCheap)’
- -H ‘accept: application/json, text/plain, /’
- -H ‘content-type: application/json’
- –data-raw ‘{“startLocationCode”:“LED”}’
- –compressed

### Страница ошибки
<img src="https://sun9-45.userapi.com/impg/iLNTbvKd6IcC3DJIlsbtCp4csfYRyW5Yy5LMTQ/7m_-mKqEudw.jpg?size=972x2160&quality=95&sign=fbd7bf76478e2a830a0965d61ea67147&type=album" alt="Alt text" width="243" height="540">

### Сколько времени потребуется на выполнение задания:
4–5 часов.
