package cn.dreampie.example;

import cn.dreampie.demo.model.Role;
import cn.dreampie.example.model.User;
import cn.dreampie.example.model.UserInfo;
import cn.dreampie.orm.DS;
import cn.dreampie.orm.Page;
import cn.dreampie.orm.Record;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.List;

/**
 * Created by ice on 15-1-4.
 */
@FixMethodOrder(MethodSorters.JVM)
public class SqlTest {
  @Before
  public void setUp() throws Exception {
    ActiveRecord.init();
  }

  @Test
  public void testSave() {
    User u = new User().set("username", "test").set("providername", "test").set("password", "123456");
    UserInfo userInfo = null;
    if (u.get("user_info") == null) {
      userInfo = new UserInfo().set("gender", 0);
    } else {
      userInfo = u.get("user_info");
    }
    if (u.save()) {
      userInfo.set("user_id", u.get("id"));
      userInfo.save();

      Role role = new Role().set("name", "test").set("value", "xx");
      role.save();
    }
    DS.use().save("sec_user", new Record().set("username", "test").set("providername", "test").set("password", "123456"));
  }

  @Test
  public void testFind() {
    List<User> users = User.dao.findAll();
    for (User user : users) {
      System.out.println(user.get("username"));
    }

    List<Record> records = DS.use().find("SELECT * FROM sec_user");
    for (Record record : records) {
      System.out.println(record.get("username"));
    }

  }

  @Test
  public void testPaginate() {
    Page<User> users = User.dao.paginateAll(1, 10);
    for (User user : users.getList()) {
      System.out.println(user.get("username"));
    }

    Page<Record> records = DS.use().paginate(1, 10, "SELECT * FROM sec_user");
    for (Record record : records.getList()) {
      System.out.println(record.get("username"));
    }
  }

  @Test
  public void testUpdate() {
    List<User> users = User.dao.findAll();
    for (User user : users) {
      user.set("username", "testupdate");
    }
    DS.use().update("UPDATE sec_user SET username='a'");
  }

  @Test
  public void testDelete() {
    List<User> users = User.dao.findAll();
    for (User user : users) {
      user.delete();
    }

    DS.use().delete("sec_user", new Record().set("id", "1"));
  }
}
