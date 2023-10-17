package com.example.movieapp.core

import kotlinx.coroutines.coroutineScope
import java.net.InetSocketAddress
import java.net.Socket

object InternetCheck {
        suspend fun isNetworkAvailable() = coroutineScope {
            return@coroutineScope try {
                val sock = Socket()
                val socketAddress = InetSocketAddress("8.8.8.8", 53)
                sock.connect(socketAddress, 2000)
                sock.close()
                true
            }catch (e: Exception) {
                false
            }
        }
}

/*
*Implementacion opcion 2

        suspend fun isNetworkAvailable() = coroutineScope {
            val sock = Socket()
            return@coroutineScope try {
                val socketAddress = InetSocketAddress("8.8.8.8", 53)
                sock.connect(socketAddress, 2000)
                true
            }catch (e: Exception){
                false
            }finally {
                sock.close()
            }
        }


* Implementacion opcion 3

        suspend fun isNetworkAvailable() = coroutineScope {
            return@coroutineScope try {
                Socket().use { sock ->
                    val socketAddress = InetSocketAddress("8.8.8.8", 53)
                    sock.connect(socketAddress, 2000)
                }
                true
            } catch (e: Exception) {
                false
            }
        }


        el metodo Socket.use() permite ejecutar un bloque y luego cerrar el Socket,
        sin importar si se lanzo o no una exception, obvio despues se debe controlar
        la exception

*/