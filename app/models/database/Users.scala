package models.database

import play.api.db.slick.Config.driver.simple._

// The static object that does the actual work - note the names of tables and fields in H2 are case sensitive and must be all caps
class Users extends Table[(Int, String, String, String, String, String, Int, Int, Int)]("USERS") {
  def id = column[Int]("ID", O.PrimaryKey, O.AutoInc)
  def username = column[String]("USERNAME")
  def name = column[String]("NAME")
  def firstname = column[String]("FIRSTNAME")
  def email = column[String]("EMAIL")
  def password = column[String]("PASSWORD")
  def city_id = column[Int]("CITY_ID")
  def country_id = column[Int]("COUNTRY_ID")
  def role_id = column[Int]("ROLE_ID")

  // Every table needs a * projection with the same type as the table's type parameter
  def * = id ~ username ~ name ~ firstname ~ email ~ password ~ city_id ~ country_id ~ role_id

}