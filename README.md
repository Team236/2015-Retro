# 2015-Retro
Retro support for the 2015 bot for demo purposes

Currently only drives the robot.


### Ports
Currently, the port numbers for drive are not imported from RobotMap. Instead,
they are replaced with their real values. This is bad form, and not how we code
our robots, but I am doing this because this is demo code. It makes it easier
for the kids without code experience to understand it at some level.
##### PWM

| Port | Subsystem | Assignment
|------|-----------|-----------
| 0 | Drive | Front Left
| 1 | Drive | Back Left
| 2 | Drive | Front Right
| 3 | Drive | Back Right

##### DIO

##### USB
| Port | Assignment
|------|-----------
| 0 | Left Joystick
| 1 | Right Joystick
| 2 | Controller