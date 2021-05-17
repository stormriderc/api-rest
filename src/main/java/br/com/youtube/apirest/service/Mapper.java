package br.com.youtube.apirest.service;

public interface Mapper<A, B> {

    B map(A input);
}
