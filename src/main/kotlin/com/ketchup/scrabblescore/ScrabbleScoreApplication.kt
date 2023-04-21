package com.ketchup.scrabblescore

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.util.*


@SpringBootApplication
class ScrabbleScoreApplication

fun main(args: Array<String>) {
	runApplication<ScrabbleScoreApplication>(*args)
}

@RestController
class ScrabbleController {
	 private val charPoints   = mapOf(
	'A' to 1, 'E' to 1, 'I' to 1, 'O' to 1, 'U' to 1, 'L' to 1, 'N' to 1, 'R' to 1, 'S' to 1, 'T' to 1,
		'D' to 2, 'G' to 2 ,
		'B' to 3, 'C' to 3, 'M' to 3, 'P' to 3,
		'F' to 4, 'H' to 4, 'V' to 4, 'W' to 4, 'Y' to 4 ,
		'K' to 5,
		'J' to 8, 'X' to 8 ,
		'Q' to 10, 'Z' to 10)

	fun calculatePoints( word: String):String {
		var points = 0

		for (char in word) {
			if(!charPoints.containsKey(char.uppercaseChar())){
				return "Invalid Word!"
			}
			points += charPoints[char.uppercaseChar()]!!
		}
		return points.toString()
	}

	@GetMapping("/")
	fun index(@RequestParam("word") word: String) = calculatePoints(word)
}







