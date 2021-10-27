# Hibernate
hibernate learnings from scratch


## commonly use hibernate annotation
- @entity = use to make any class as entity
- @table = use to chnage table details
- @id = use to mark column as id (primary key)
- @generatedvalue = automatic generate values i.e auto increment
- @column = specify column mapping/details
- @transient = this tells the hibernate not to save this field
- @temporal = format to save date
- @lob = large object
- @onetoone , @manytoone etc etc .............


## Fetch type
2 types => lazy and eager
1. eager = design patter in which data loads on the spot
2. lazy = data loads only when we explicitly call the getter and setter methods
