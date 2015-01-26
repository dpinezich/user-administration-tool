package models.database

import play.api.db.slick.Config.driver.simple._

// The static object that does the actual work - note the names of tables and fields in H2 are case sensitive and must be all caps
class Countries extends Table[(Int, String)]("COUNTRIES") {
  def id = column[Int]("ID", O.PrimaryKey, O.AutoInc)
  def name = column[String]("NAME")

  // Every table needs a * projection with the same type as the table's type parameter
  def * = id ~ name

}