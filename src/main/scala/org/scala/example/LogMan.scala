package org.scala.example

import java.util.Properties

import org.apache.log4j.{Logger, PropertyConfigurator}

trait LogMan extends Serializable {
  protected val logConfFile: String = "etl_console.properties"

  //对象不用序列化
  @transient private var log_ : Logger = null

  // Method to get the logger name for this object
  protected def logName = {
    // Ignore trailing $'s in the class names for Scala objects
    this.getClass.getName.stripSuffix("$")
  }

  // Method to get or create the logger for this object
  protected def log: Logger = {
    if (log_ == null) {
      initializeLogIfNecessary()
      log_ = org.apache.log4j.Logger.getLogger(logName)
    }
    log_
  }

  // Log methods that take only a String
  protected def logInfo(msg: => String) {
    if (log.isInfoEnabled) log.info(msg)
  }

  protected def logDebug(msg: => String) {
    if (log.isDebugEnabled) log.debug(msg)
  }

  protected def logTrace(msg: => String) {
    if (log.isTraceEnabled) log.trace(msg)
  }

  protected def logWarning(msg: => String) {
    log.warn(msg)
  }

  protected def logError(msg: => String) {
    log.error(msg)
  }


  protected def initializeLogIfNecessary(): Unit = {
    if (!LogMan.initialized) {
      initializeLogging()
    }
  }


  private def initializeLogging(): Unit = {
    // Don't use a logger in here, as this is itself occurring during initialization of a logger
    // If Log4j 1.2 is being used, but is not initialized, load a default properties file
    val defaultLogProps = logConfFile
    val props = new Properties()
    props.load(getClass.getClassLoader.getResourceAsStream(defaultLogProps))
    PropertyConfigurator.configure(props)
  }
}


private object LogMan {
  //@volatile 可以被多个线程同时更新
  @volatile private var initialized = false
}
