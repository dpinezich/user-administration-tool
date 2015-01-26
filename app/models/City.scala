package models
// Importing the slick driver
import models.database.Cities
import play.api.Play.current
import play.api.db.slick.Config.driver.simple._
import play.api.db.slick.DB
import scala.slick.session.Session

// The case class to represent the data object
case class City(id: Option[Int] = None, name: String)


object City {

  val table = new Cities

  def find: List[(Int, String)] = DB.withSession { implicit session: Session =>
    Query(table).list
  }

  def findCityNames: List[String] = DB.withSession { implicit session: Session =>
    Query(table).map(_.name).list
  }

}
