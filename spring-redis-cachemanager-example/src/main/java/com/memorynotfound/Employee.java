package com.memorynotfound;

import java.io.Serializable;

public class Employee implements Serializable
{

		private static final long serialVersionUID = 0;

		public enum Gender{Male, Female}
		
		private String id;
		
		private String name;
		
		private Gender gender;
		
		private int age;

		public String getId()
		{
				return id;
		}

		public void setId(String id)
		{
				this.id = id;
		}

		public String getName()
		{
				return name;
		}

		public void setName(String name)
		{
				this.name = name;
		}

		public Gender getGender()
		{
				return gender;
		}

		public void setGender(Gender gender)
		{
				this.gender = gender;
		}

		public int getAge()
		{
				return age;
		}

		public void setAge(int age)
		{
				this.age = age;
		}
		

		@Override
		public String toString()
		{
				return "[id=" + id + ", name=" + name + ", gender=" + gender + ", age=" + age + "]";
		}
		
		
		
}
