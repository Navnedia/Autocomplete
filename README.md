# Autocomplete
A Java demo application for autocomplete functionality. After running the `AutocompleteGUI.java` select the data set to run the demo on.
As you type, you will see real-time relevant suggestions from the data set appear that match the prefix you've typed in. Suggestions are sorted by a weight assigned
in the data set, so the more relevant items are always at the top; for example, with the `imdb-votes.txt` dataset, each movie is given a weight based on the number
of votes it has on IMDB. At any time you can select the suggestion and launch the query in your browser.

The algorithm behind this is a binary search that has been modified to search for a prefix of the entries.

# Screenshots

![auto-complete-pick 2](https://github.com/Navnedia/Autocomplete/blob/main/screenshots/auto-complete-pick%202.png)
![auto-complete-search 2](https://github.com/Navnedia/Autocomplete/blob/main/screenshots/auto-complete-search%202.png)
![auto-complete-search](https://github.com/Navnedia/Autocomplete/blob/main/screenshots/auto-complete-search.png)
