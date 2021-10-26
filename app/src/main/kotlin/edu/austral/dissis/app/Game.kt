package edu.austral.dissis.app

import edu.austral.dissis.file.ImageLoader
import edu.austral.dissis.game.*
import javafx.scene.Node
import javafx.scene.Parent
import javafx.scene.image.ImageView
import javafx.scene.input.KeyCode
import javafx.scene.layout.Pane
import javafx.scene.layout.StackPane
import javafx.scene.text.Text

class Game : GameApplication() {
    override fun setupWindow(): WindowSettings {
        return WindowSettings.fromTitle("Starships!")
    }

    override fun initRoot(context: GameContext): Parent {
        return GameManager(this, context).init()
    }
}

class GameManager(private val rootSetter: RootSetter, private val context: GameContext) {
    private var isIntro = true

    fun init(): Parent {
        val parent = if (isIntro) loadIntro() else loadGame()

        parent.setOnMouseClicked {
            handleMouseClick()
        }

        return parent
    }

    private fun handleMouseClick() {
        isIntro = !isIntro
        rootSetter.setRoot(init())
    }

    private fun loadIntro(): Parent {
        val title = Text("Welcome! Click!")

        return StackPane(title)
    }


    private fun loadGame(): Parent {
        val imageLoader = ImageLoader()
        val image = imageLoader.loadFromResources("starship.png", 60.0, 60.0)
        val imageView = ImageView(image)

        imageView.layoutX = 200.0
        imageView.layoutY = 200.0

        val pane = Pane(imageView)

        MainTimer(imageView, context.keyTracker).start()

        return pane
    }

}

class MainTimer(private val ship: Node, private val keyTracker: KeyTracker) : GameTimer() {


    override fun nextFrame(secondsSinceLastFrame: Double) {
        updatePosition(secondsSinceLastFrame)
    }

    private fun updatePosition(secondsSinceLastFrame: Double) {
        val movement = 50 * secondsSinceLastFrame

        keyTracker.keySet.forEach { keyCode ->
            when (keyCode) {
                KeyCode.UP -> ship.layoutY = ship.layoutY - movement
                KeyCode.DOWN -> ship.layoutY = ship.layoutY + movement
                KeyCode.LEFT -> ship.layoutX = ship.layoutX - movement
                KeyCode.RIGHT -> ship.layoutX = ship.layoutX + movement

                else -> {
                }
            }

        }
    }
}