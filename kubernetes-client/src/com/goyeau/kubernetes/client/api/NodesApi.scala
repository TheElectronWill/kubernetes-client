package com.goyeau.kubernetes.client.api

import cats.effect.Async
import com.goyeau.kubernetes.client.KubeConfig
import com.goyeau.kubernetes.client.operation._
import io.circe._
import io.k8s.api.core.v1.{Node, NodeList}
import org.http4s.Uri
import org.http4s.client.Client
import org.http4s.implicits._

private[client] class NodesApi[F[_]](val httpClient: Client[F], val config: KubeConfig)(implicit
    val F: Async[F],
    val listDecoder: Decoder[NodeList],
    val resourceDecoder: Decoder[Node]
) extends Listable[F, NodeList] {
  val resourceUri: Uri = uri"/apis" / "v1" / "nodes"

}
