package com.yandex.mapkitdemo.objects

import com.yandex.mapkit.geometry.Circle
import com.yandex.mapkit.geometry.LinearRing
import com.yandex.mapkit.geometry.Point
import com.yandex.mapkit.geometry.Polygon
import com.yandex.mapkit.geometry.Polyline
import com.yandex.mapkit.map.CameraPosition
import kotlin.random.Random

object GeometryProvider {

    val startPosition = CameraPosition(Point(59.935016, 30.328903), 15f, 0f, 0f)

    val compositeIconPoint = Point(59.939651, 30.339902)

    val animatedImagePoint = Point(59.932305, 30.338758)

    val polygon: Polygon
        get() {
            var points = listOf(
                59.935535 to 30.326926,
                59.938961 to 30.328576,
                59.938152 to 30.336384,
                59.934600 to 30.335049,
            ).map { (lat, lon) -> Point(lat, lon) }

            points = points.toMutableList() + points.first()
            val ring = LinearRing(points)

            val innerRing = listOf(
                59.936698 to 30.331271,
                59.937495 to 30.329910,
                59.937854 to 30.331909,
                59.937112 to 30.333312,
                59.936698 to 30.331271,
            )
                .map { (lat, lon) -> Point(lat, lon) }
                .let { LinearRing(it) }

            return Polygon(
                ring,
                listOf(innerRing)
            )
        }


    val polyline: Polyline
        get() {
            val points = listOf(
                59.933475 to 30.325256,
                59.933947 to 30.323115,
                59.935667 to 30.324070,
                59.935901 to 30.322370,
                59.941026 to 30.324789,
            ).map { (lat, lon) -> Point(lat, lon) }
            return Polyline(points)
        }

    fun circle(): Circle {
        return Circle(
            Point(59.939866, 30.314352),
            (200..600).random().toFloat()
        )
    }

    val clusterizedPoints = List(20_000) {
        Random.nextDouble(-90.000000, 90.000000) to Random.nextDouble(-180.000000, 180.000000)
    }.map { (lat, lon) -> Point(lat, lon) }
}
