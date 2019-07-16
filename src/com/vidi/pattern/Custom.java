package com.vidi.pattern;

/**
 * @Author : Vidi
 * @Date : 2019/6/17 9:19
 * @Descripton :
 */
public class Custom {
	private Integer age;
	private String name;
	private String address;

	static Custom.Builder builder() {
		return new Custom.Builder();
	}

	private Custom(Builder builder) {
		this.age = builder.age;
		this.name = builder.name;
		this.address = builder.address;
	}

	@Override
	public String toString() {
		return "Custom{" +
				"age=" + age +
				", name='" + name + '\'' +
				", address='" + address + '\'' +
				'}';
	}

	public static class Builder {
		private Integer age;
		private String name;
		private String address;

		public Builder age(Integer age) {
			this.age = age;
			return this;
		}

		public Builder name(String name) {
			this.name = name;
			return this;
		}

		public Builder address(String address) {
			this.address = address;
			return this;
		}

		Custom build() {
			return new Custom(this);
		}
	}

	public static void main(String[] args) {
		Custom custom = Custom.builder().age(11).name("Vidi").address("London").build();
		System.out.println(custom);
	}
}
