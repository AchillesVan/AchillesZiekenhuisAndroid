//[app](../../../index.md)/[com.example.achillesziekenhuis.data.database](../index.md)/[AgendaslotDao](index.md)

# AgendaslotDao

[androidJvm]\
interface [AgendaslotDao](index.md)

Data access object for [DbAgendaslot](../-db-agendaslot/index.md) table.

## Functions

| Name | Summary |
|---|---|
| [delete](delete.md) | [androidJvm]<br>abstract suspend fun [delete](delete.md)(item: [DbDokter](../-db-dokter/index.md))<br>Delete a [DbAgendaslot](../-db-agendaslot/index.md) from the [DbAgendaslot](../-db-agendaslot/index.md) table. |
| [getItemByRizivAndDate](get-item-by-riziv-and-date.md) | [androidJvm]<br>abstract fun [getItemByRizivAndDate](get-item-by-riziv-and-date.md)(rizivNummer: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), startTijd: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): Flow&lt;[List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[DbAgendaslot](../-db-agendaslot/index.md)&gt;&gt;<br>Get all the [DbAgendaslot](../-db-agendaslot/index.md) with a specific riziv number and start time from the [DbAgendaslot](../-db-agendaslot/index.md) table. |
| [getItemByRRN](get-item-by-r-r-n.md) | [androidJvm]<br>abstract fun [getItemByRRN](get-item-by-r-r-n.md)(rijksregisternummer: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): Flow&lt;[List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[DbAgendaslot](../-db-agendaslot/index.md)&gt;&gt;<br>Get all the [DbAgendaslot](../-db-agendaslot/index.md) with a specific National Insurance number from the [DbAgendaslot](../-db-agendaslot/index.md) table. |
| [insert](insert.md) | [androidJvm]<br>abstract suspend fun [insert](insert.md)(item: [DbAgendaslot](../-db-agendaslot/index.md))<br>Insert a [DbAgendaslot](../-db-agendaslot/index.md) into the [DbAgendaslot](../-db-agendaslot/index.md) table. |
| [update](update.md) | [androidJvm]<br>abstract suspend fun [update](update.md)(item: [DbDokter](../-db-dokter/index.md))<br>Update a [DbAgendaslot](../-db-agendaslot/index.md) in the [DbAgendaslot](../-db-agendaslot/index.md) table. |
