# Marvin  <img align="right" width="45" height="45" src="https://github.com/stuparmihailo/marvin/raw/master/resources/images/marvin-logo.png">
> DevoOps? Don't talk to me about DevOps.

Marvin is a slack bot which will execute any command that you define. DevOps engineers could create the scripts, and Marvin is going to execute them when you type the command. 
Currently, the Marvin is implemented in Java as a Spring Boot application, but in future, it will be implemented also in Python (with tensor flow capabilities) so you will be able to really chat with Marvin and he will execute the commands/scripts for you.

### How it works
Marvin is a bridge between slack commands and the scripts that you defined. When you start Marvin, you are only able to ask him for a help:
```/marvin help```
And he is going to respond with:
```Don’t pretend you want to talk to me, I know you hate me.```


His reply is actually part of the script called ```help.sh```. You are able to change it, and also add more scrips (i.e. ```get-logs.sh```) . Then you can ask Marvin from slack:
```/marvin get-logs```
And the respond is actually the StdOut of your linux script (```get-logs.sh```):
```
[INFO] POST request executed with status code 200
...
...
```
### Installation
One and only prerequisite is docker. Marvin is tested with version ```17.12.0-ce```. 
```
docker run -d -v /host/path/to/scripts:/opt -p host-port:8080 stupar/marvin
```
In the commands above, two parameters are very important:
1) ```-v /host/path/to/scripts:/opt``` Host path to scripts is the location where the DevOps engineers will locate their scripts, and they will be automatically recognized as slack commands.
2) ```-p host-port:8080``` From container perspective, Marvin listens on port 8080. With this parameter, the port mapping is defined and the Marvin is accessible on port ```host-port```

### Basic usage   

