# AND101 Project 6 - CYOAPI Part 2: RecyclerView Edition

Submitted by: **Brian Zhang**

Time spent: **3** hours spent in total

## Summary

**Pokemon Dictionary** is an android app that provides a scrollable and searchable list of Pokemon, utilizing the PokeAPI to fetch information. Users can view details about each Pokemon, including an image and name, with functionality to load data for a random Pokemon or search for one by name. The app enhances user interaction with features like infinite scrolling and search queries, making it a comprehensive tool for exploring Pokemon data.

If I had to describe this project in three (3) emojis, they would be: **🔥🥬🌊**

## Application Features

The following REQUIRED features are completed:

- [X] Make an API call to an API of your choice using AsyncHTTPClient
- [X] Implement a RecyclerView to display a list of entries from the API
- [X] Display at least three (3) pieces of data for each RecyclerView item

The following STRETCH features are implemented:

- [X] Add a UI element for the user to interact with API further
- [X] Show a `Toast` or `Snackbar` when an item is clicked
- [X] Add item dividers with `DividerItemDecoration`

## Video Demo

Here's a video / GIF that demos all of the app's implemented features:

<p align="center">
  <img src="RandomPokemon2.gif" title='Video Demo' width='' alt='Video Demo' />
</p>

GIF created with **ScreenToGif**

<!-- Recommended tools:
- [Kap](https://getkap.co/) for macOS
- [ScreenToGif](https://www.screentogif.com/) for Windows
- [peek](https://github.com/phw/peek) for Linux. -->

## Notes

- **Random Generation Feature:** Enables spontaneous discovery of Pokemon through random generation.
- **Search Functionality:** Allows for specific Pokemon searches by name.
- **Infinite Scrolling:** Continuously loads new Pokemon data at the list's end for endless exploration.
- **Interactive List Display:** Shows Pokemon details (image, name, description placeholder) in a scrollable format.
- **Data Fetching and Handling:** Uses AsyncHttpClient for efficient network requests and JSON processing from the PokeAPI.
- **User Feedback:** Provides interactive feedback with Toast messages upon selecting a Pokemon.
- **Efficient Data Management:** Dynamically updates the Pokemon list using a MutableList and adapter notifications.
- **Custom Adapter Implementation:** Manages RecyclerView binding with a focus on performance, including image handling with Glide.
- **Modular Design:** Demonstrates organized and maintainable coding practices suitable for Android development.

## License

Copyright **2024** **Brian Zhang**

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
