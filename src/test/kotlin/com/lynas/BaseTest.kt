package com.lynas

import org.junit.jupiter.api.BeforeEach
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.context.annotation.Import
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.setup.MockMvcBuilders
import org.springframework.web.context.WebApplicationContext
import org.testcontainers.junit.jupiter.Testcontainers

@Import(TestcontainersConfiguration::class)
@Testcontainers(parallel = true)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class BaseTest {
	lateinit var mockMvc: MockMvc

	@Autowired
	protected lateinit var webApplicationContext: WebApplicationContext

	@BeforeEach
	fun setup() {
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build()
	}
}
