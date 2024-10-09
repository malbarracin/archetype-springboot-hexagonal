def dir = new File(new File(request.outputDirectory), request.artifactId)

def run(String cmd) {
    def process = cmd.execute(null, dir)
    process.waitForProcessOutput((Appendable)System.out, System.err)
    if (process.exitValue() != 0) {
        throw new Exception("Command '$cmd' exited with code: ${process.exitValue()}")
    }
}

//----------------------------------------------------------------------------------

checkSwaggerFile = {

    Properties properties = request.properties
    def swaggerEnable = properties.get("swaggerenable")
    def groupId = request.groupId
    def pathGroupId = groupId.replace('.', File.separator)

    // Loguear el valor de swaggerEnable
    println "Valor de swaggerEnable: $swaggerEnable"

    if (swaggerEnable == "false") {
        //run("pwd")

        println "dir: $dir"

        def path = "$dir" + File.separator + "src" + File.separator + "main" + File.separator + "java" + File.separator + "$pathGroupId" + File.separator + "config"

        println "path: $path"
        def directorio = new File(path)
        def archivoABorrar = new File(directorio, "SwaggerConfig.java")

        if (archivoABorrar.exists()) {
            archivoABorrar.delete()
            println "El archivo se ha borrado exitosamente."
        } else {
            println "El archivo no existe."
        }

        //run("rm -f $dir/src/main/resources/archetype-resources/src/main/java/__packageInPathFormat__/config/SwaggerConfig.java")
    }

}

checkAsyncFiles = {
    Properties properties = request.properties
    def asyncEnable = properties.get("httpReactivaEnable")
    def groupId = request.groupId
    def pathGroupId = groupId.replace('.', File.separator)

    // Loguear el valor de httpReactivaEnable
    println "Valor de httpReactivaEnable: $asyncEnable"

    if (asyncEnable == "false") {
        println "dir: $dir"

        def pathprincipal = "$dir" + File.separator + "src" + File.separator + "main" + File.separator + "java" + File.separator + "$pathGroupId"
        println "path: $pathprincipal"

        //------------------------------------------------------------------------------------
        // Archivo 1
        def path = pathprincipal + File.separator + "adapter" + File.separator + "in" + File.separator + "client"

        def directorio = new File(path)
        def archivoABorrar = new File(directorio, "ExternalPostsAsyncClientImpl.java")

        if (archivoABorrar.exists()) {
            archivoABorrar.delete()
            println "El archivo ExternalPostsAsyncClientImpl se ha borrado exitosamente."
        } else {
            println "El archivo ExternalPostsAsyncClientImpl no existe."
        }

        //------------------------------------------------------------------------------------
        // Archivo 2
        path = pathprincipal + File.separator + "adapter" + File.separator + "in" + File.separator + "controller"

        directorio = new File(path)
        archivoABorrar = new File(directorio, "PostAsyncController.java")

        if (archivoABorrar.exists()) {
            archivoABorrar.delete()
            println "El archivo PostAsyncController se ha borrado exitosamente."
        } else {
            println "El archivo PostAsyncController no existe."
        }

        //------------------------------------------------------------------------------------
        // Archivo 3
        path = pathprincipal + File.separator + "application"

        directorio = new File(path)
        archivoABorrar = new File(directorio, "PostAsyncUsecase.java")

        if (archivoABorrar.exists()) {
            archivoABorrar.delete()
            println "El archivo PostAsyncUsecase se ha borrado exitosamente."
        } else {
            println "El archivo PostAsyncUsecase no existe."
        }

        //------------------------------------------------------------------------------------
        // Archivo 4
        path = pathprincipal + File.separator + "domain" + File.separator + "ports"

        directorio = new File(path)
        archivoABorrar = new File(directorio, "ExternalPostsAsyncClient.java")

        if (archivoABorrar.exists()) {
            archivoABorrar.delete()
            println "El archivo ExternalPostsAsyncClient se ha borrado exitosamente."
        } else {
            println "El archivo ExternalPostsAsyncClient no existe."
        }

        //------------------------------------------------------------------------------------
        // Archivo 5
        path = pathprincipal + File.separator + "domain" + File.separator + "service"

        directorio = new File(path)
        archivoABorrar = new File(directorio, "PostAsyncService.java")

        if (archivoABorrar.exists()) {
            archivoABorrar.delete()
            println "El archivo PostAsyncService se ha borrado exitosamente."
        } else {
            println "El archivo PostAsyncService no existe."
        }
    }
}

checkSwaggerFile()
checkAsyncFiles()