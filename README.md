# PixelChewing
Class assignment - GUI with pixels and threads
At first, set square edge length, amount of transitions and amount of thread for process.
Then you'll get a board with "ON" pixels. You can switch pixels with your mouse.
When u ready press "GO" and the pixels will change theirs state depends on the TRANSITIONS RULE - see below.

* TRANSITIONS RULE
Transition rule: if a pixel has at least one white neighbor it becomes white.
Process: each tread represent an individual pixel and check his neighbors. When all threads done, the board repaint.

* 'Square egde length' is the amount of pixels in the edge of the square.
