package com.lynas

import org.springframework.boot.fromApplication
import org.springframework.boot.with


fun main(args: Array<String>) {
	fromApplication<SpringGithubActionDockerDbTestApplication>().with(TestcontainersConfiguration::class).run(*args)
}
