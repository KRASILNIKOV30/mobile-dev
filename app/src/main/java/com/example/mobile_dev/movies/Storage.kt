package com.example.mobile_dev.movies

import kotlin.random.Random

object Storage {
    val movies by lazy {
        val result = mutableListOf<Movie>()

        movieTitles.mapIndexedTo(result) { index, title ->
            Movie(
                title = title,
                description = movieDescriptions[index],
                rate = Random.nextDouble(0.0, 5.0),
                imageUrl = movieImageUrls[index]
            )
        }

        result.shuffle()

        return@lazy result
    }

    private val movieTitles = listOf(
        "Inception",
        "The Matrix",
        "Pulp Fiction",
        "The Shawshank Redemption",
        "The Godfather",
        "Forrest Gump",
        "The Dark Knight",
        "Fight Club",
        "Gladiator",
        "Titanic",
        "Jurassic Park",
        "Avatar",
        "The Avengers",
        "The Lord of the Rings: The Fellowship of the Ring",
        "Interstellar",
        "Black Panther",
        "Spider-Man: Into the Spider-Verse",
        "The Silence of the Lambs",
        "The Social Network",
        "Coco"
    )

    private val movieDescriptions = listOf(
        "Inception: A skilled thief, who specializes in corporate espionage through dream-sharing technology, is given a chance to have his criminal history erased if he can successfully plant an idea in someone’s mind.",
        "The Matrix: A computer hacker discovers that reality is a simulated construct controlled by sentient machines and joins a rebellion to free humanity from their digital enslavement. The Matrix: A computer hacker discovers that reality is a simulated construct controlled by sentient machines and joins a rebellion to free humanity from their digital enslavement. The Matrix: A computer hacker discovers that reality is a simulated construct controlled by sentient machines and joins a rebellion to free humanity from their digital enslavement. The Matrix: A computer hacker discovers that reality is a simulated construct controlled by sentient machines and joins a rebellion to free humanity from their digital enslavement. The Matrix: A computer hacker discovers that reality is a simulated construct controlled by sentient machines and joins a rebellion to free humanity from their digital enslavement. The Matrix: A computer hacker discovers that reality is a simulated construct controlled by sentient machines and joins a rebellion to free humanity from their digital enslavement. The Matrix: A computer hacker discovers that reality is a simulated construct controlled by sentient machines and joins a rebellion to free humanity from their digital enslavement. The Matrix: A computer hacker discovers that reality is a simulated construct controlled by sentient machines and joins a rebellion to free humanity from their digital enslavement. The Matrix: A computer hacker discovers that reality is a simulated construct controlled by sentient machines and joins a rebellion to free humanity from their digital enslavement. The Matrix: A computer hacker discovers that reality is a simulated construct controlled by sentient machines and joins a rebellion to free humanity from their digital enslavement. The Matrix: A computer hacker discovers that reality is a simulated construct controlled by sentient machines and joins a rebellion to free humanity from their digital enslavement. The Matrix: A computer hacker discovers that reality is a simulated construct controlled by sentient machines and joins a rebellion to free humanity from their digital enslavement. The Matrix: A computer hacker discovers that reality is a simulated construct controlled by sentient machines and joins a rebellion to free humanity from their digital enslavement. The Matrix: A computer hacker discovers that reality is a simulated construct controlled by sentient machines and joins a rebellion to free humanity from their digital enslavement. The Matrix: A computer hacker discovers that reality is a simulated construct controlled by sentient machines and joins a rebellion to free humanity from their digital enslavement. The Matrix: A computer hacker discovers that reality is a simulated construct controlled by sentient machines and joins a rebellion to free humanity from their digital enslavement. The Matrix: A computer hacker discovers that reality is a simulated construct controlled by sentient machines and joins a rebellion to free humanity from their digital enslavement. The Matrix: A computer hacker discovers that reality is a simulated construct controlled by sentient machines and joins a rebellion to free humanity from their digital enslavement. The Matrix: A computer hacker discovers that reality is a simulated construct controlled by sentient machines and joins a rebellion to free humanity from their digital enslavement. The Matrix: A computer hacker discovers that reality is a simulated construct controlled by sentient machines and joins a rebellion to free humanity from their digital enslavement.",
        "Pulp Fiction: This iconic crime drama intertwines several stories of Los Angeles mobsters, fringe players, and a mysterious briefcase, all told in a nonlinear narrative.",
        "The Shawshank Redemption: Wrongly imprisoned for murder, Andy Dufresne forms a friendship with fellow inmate Red as they navigate life in Shawshank State Penitentiary and find hope amid despair.",
        "The Godfather: The aging patriarch of an organized crime dynasty transfers control of his clandestine empire to his reluctant son, while facing threats from rival families.",
        "Forrest Gump: An earnest man with a low IQ inadvertently influences several historical events in the 20th century while trying to reunite with his childhood sweetheart.",
        "The Dark Knight: Batman faces his greatest challenge yet in the form of the Joker, a criminal mastermind who seeks to plunge Gotham City into anarchy.",
        "Fight Club: An insomniac office worker forms an underground fight club with a soap salesman, leading to an exploration of identity and consumerism.",
        "Gladiator: A betrayed Roman general seeks vengeance against the corrupt emperor who murdered his family and sent him into slavery, fighting his way back to power.",
        "Titanic: A love story unfolds aboard the ill-fated RMS Titanic, where a wealthy young woman and a penniless artist fall in love against the backdrop of class division and impending tragedy.",
        "Jurassic Park: A theme park featuring cloned dinosaurs faces disaster when the creatures escape, forcing the guests to fight for survival amid the chaos.",
        "Avatar: A paraplegic marine is sent to the lush alien world of Pandora, where he becomes torn between following his orders and protecting the native Na'vi people.",
        "The Avengers: Earth's mightiest heroes must assemble to save the world from an extraterrestrial threat, blending their unique powers and personalities in the process.",
        "The Lord of the Rings: The Fellowship of the Ring: A hobbit sets out on a perilous journey to destroy a powerful ring, joined by a diverse fellowship of heroes in a battle against dark forces.",
        "Interstellar: A team of explorers travels through a wormhole in search of a new home for humanity as Earth faces an impending ecological disaster.",
        "Black Panther: The newly crowned king of Wakanda must defend his nation from external forces while embracing his role as the protector of a hidden and advanced civilization.",
        "Spider-Man: Into the Spider-Verse: Teenager Miles Morales becomes Spider-Man and teams up with various versions of the hero from different dimensions to save their realities.",
        "The Silence of the Lambs: A young FBI trainee seeks the help of an imprisoned cannibalistic serial killer to catch another serial killer on the loose.",
        "The Social Network: The story of the founding of Facebook explores themes of ambition, betrayal, and the impact of social media on personal relationships.",
        "Coco: A young boy named Miguel embarks on a journey to the Land of the Dead to discover his family's history and pursue his passion for music, celebrating the importance of heritage and memory."
    )

    private val movieImageUrls = listOf(
        "https://upload.wikimedia.org/wikipedia/en/7/7f/Inception_ver3.jpg", // Inception
        "https://upload.wikimedia.org/wikipedia/en/c/c1/The_Matrix_Poster.jpg", // The Matrix
        "https://upload.wikimedia.org/wikipedia/en/8/81/Pulp_Fiction_cover.jpg", // Pulp Fiction
        "https://upload.wikimedia.org/wikipedia/en/8/81/ShawshankRedemptionMoviePoster.jpg", // The Shawshank Redemption
        "https://upload.wikimedia.org/wikipedia/en/1/1c/Godfather_ver1.jpg", // The Godfather
        "https://upload.wikimedia.org/wikipedia/en/6/67/Forrest_Gump_poster.jpg", // Forrest Gump
        "https://upload.wikimedia.org/wikipedia/en/8/8a/Dark_Knight.jpg", // The Dark Knight
        "https://upload.wikimedia.org/wikipedia/en/f/f9/Fight_Club_poster.jpg", // Fight Club
        "https://upload.wikimedia.org/wikipedia/en/8/8a/Gladiator_ver1.jpg", // Gladiator
        "https://upload.wikimedia.org/wikipedia/en/2/22/Titanic_poster.jpg", // Titanic
        "https://upload.wikimedia.org/wikipedia/en/e/e7/Jurassic_Park_poster.jpg", // Jurassic Park
        "https://upload.wikimedia.org/wikipedia/en/b/b9/Avatar-Teaser-Poster.jpg", // Avatar
        "https://upload.wikimedia.org/wikipedia/en/0/0c/TheAvengers2012Poster.jpg", // The Avengers
        "https://upload.wikimedia.org/wikipedia/en/d/d3/The_Lord_of_the_Rings_-_The_Fellowship_of_the_Ring.jpg", // The Fellowship of the Ring
        "https://upload.wikimedia.org/wikipedia/en/b/bf/Interstellar_film_poster.jpg", // Interstellar
        "https://upload.wikimedia.org/wikipedia/en/0/0f/Black_Panther_film_poster.jpg", // Black Panther
        "https://upload.wikimedia.org/wikipedia/en/3/39/Spider-Man_Into_the_Spider-Verse_poster.jpg", // Spider-Man: Into the Spider-Verse
        "https://upload.wikimedia.org/wikipedia/en/8/87/The_Silence_of_the_Lambs.jpg", // The Silence of the Lambs
        "https://upload.wikimedia.org/wikipedia/en/7/7e/Social_network_film_poster.jpg", // The Social Network
        "https://upload.wikimedia.org/wikipedia/en/6/61/Coco_Poster.jpg" // Coco
    )
}