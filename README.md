# withdrawal is a poorly implemented rough sketch prototype of a utility that reads data from any form of an excel file xls, or xlsx and saves the same into a database. This is usually after creating objects per row. The cells per row consist the individual fields of the object. This allows me to use JPA to persist them to mysql.The reason I say it is poor;y implemented is because the number of fieds the object can have is fixed. I would rather create an object with dynamic number of fields then persist it in the database. This way I do not have to adjust my fields for every project. But this project has a short timeine before it needs to be completed. There are also something like 9 worksheets with 65,000 rows each. Immediately you try anything with excel using this, excel will just stop working... So java to the rescue
