package org.example.callbacks

import java.awt.BorderLayout
import java.awt.Dimension
import javax.swing.*

object Display {

    private val infoArea = JTextArea().apply {
        isEditable = false
    }

    private val loadButton = JButton("Load Book")
    private val timerLabel = JLabel("Timer: 00:00")
    private val topPanel = JPanel(BorderLayout()).apply {
        add(timerLabel, BorderLayout.WEST)
        add(loadButton, BorderLayout.EAST)
    }

    private val mainFrame = JFrame("Book and Author info.").apply {
        layout = BorderLayout()
        add(topPanel, BorderLayout.NORTH)
        add(JScrollPane(infoArea), BorderLayout.CENTER)
        size = Dimension(800, 600)
    }

    fun show() {
        mainFrame.isVisible = true
    }
}