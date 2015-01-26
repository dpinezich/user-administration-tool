import play.api.db.DB
import play.api.GlobalSettings
// Use H2Driver to connect to an H2 database
import play.api.db.slick.Config.driver.simple._



import play.api.Application
import play.api.Play.current

import models._


object Global extends GlobalSettings {

  override def onStart(app: Application) {

    InitialData.insert()

  }

  object InitialData {


    def insert() = {

    }
  }
}