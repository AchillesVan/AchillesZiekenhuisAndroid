//[app](../../../index.md)/[com.example.achillesziekenhuis.data.database](../index.md)/[AgendaslotDao](index.md)/[getItemByRizivAndDate](get-item-by-riziv-and-date.md)

# getItemByRizivAndDate

[androidJvm]\
abstract fun [getItemByRizivAndDate](get-item-by-riziv-and-date.md)(rizivNummer: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), startTijd: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): Flow&lt;[List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[DbAgendaslot](../-db-agendaslot/index.md)&gt;&gt;

Get all the [DbAgendaslot](../-db-agendaslot/index.md) with a specific riziv number and start time from the [DbAgendaslot](../-db-agendaslot/index.md) table.
