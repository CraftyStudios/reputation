## Template for Spigot Maven plugins

## How to use:

First, make sure you edit all the values in pom.xml. Those include:

        <mc.version>MINECRAFT VERSION</mc.version> (default value is 1.19.3 so there is no pom.xml errors)
        <groupId>YOURNAME</groupId>
        <artifactId>PLUGINNAME</artifactId>
        <version>VERSION</version>

Then, you can rename your packages. In VSCode, you can right click on the folder names and click rename. This will not refractor the code however, so you have to edit the package names in each file yourself. If your using intellij, then you can refractor the names. 


Make sure you have a JDK installed
    
Then, you can run the following commands in the terminal:
    
        mvn clean install
        mvn compile
        mvn package

Make sure that you have maven. If you don't, you can download it here: https://maven.apache.org/download.cgi


## Importing other plugins:

If you want to import other plugins, you can do so by adding the following to your pom.xml:

    <dependency>
        <groupId></groupId>
        <artifactId></artifactId>
        <version></version>
        <scope></scope>
    </dependency>

Be sure to replace the values with the values from the plugin you want to import. You can find the values by going to the plugin's wiki page. Most plugins have this if they can be imported.

## Output:

The output of the plugin will be in the target folder. The jar file will be in the target folder. The jar file will be named "PLUGINNAME-VERSION.jar". You can rename this file to whatever you want.

## Directory:

The output directory will be in a directory called `out`. The jar will show up there. Put this in the .gitignore file if you have your project public on github or other sites.

## Done:

You are now done! You can now start coding your plugin. If you have any questions, feel free to ask me on discord: `Incbom#1877`
