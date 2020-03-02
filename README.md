# PixelChewing
Class assignment - GUI with pixels and threads
At first set square edge length, amount of transitions and amount of thread for process.
Then you will have a board and you can switch pixels with your mouse.
when ready press "GO" and the pixels will change theirs state depends on TRANSITION RULE - see below.

Square egde length is the amount of pixels in the edge of the square.
Transition rule: if a pixel has at least one white neighbor it becomes white.
Process: each tread run an individual pixel and check his neighbors - after all pixels finished the board repaint
