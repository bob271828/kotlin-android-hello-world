class MainActivity : AppCompatActivity() {
    lateinit var server: SimpleHttpServer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Start the HTTP server on port 8080
        server = SimpleHttpServer(8080)
        server.start()
        println("HTTP server started on port 8080")
    }

    override fun onDestroy() {
        super.onDestroy()
        // Stop the server when the activity is destroyed
        server.stop()
    }
}
