package cc.chordflower.dracpond.cryptofs;

/*-
 * #%L
 * dracpond-cryptofs
 * %%
 * Copyright (C) 2020 carddamom
 * %%
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 * #L%
 */

import java.io.IOException;
import java.net.URI;
import java.nio.channels.SeekableByteChannel;
import java.nio.file.AccessMode;
import java.nio.file.CopyOption;
import java.nio.file.DirectoryStream;
import java.nio.file.DirectoryStream.Filter;
import java.nio.file.FileStore;
import java.nio.file.FileSystem;
import java.nio.file.LinkOption;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileAttribute;
import java.nio.file.attribute.FileAttributeView;
import java.nio.file.spi.FileSystemProvider;
import java.util.Map;
import java.util.Set;

public final class CryptoFileSystemProvider extends FileSystemProvider {

  @Override
  public String getScheme( ) {
    return null;
  }

  @Override
  public FileSystem newFileSystem( URI uri, Map< String, ? > env ) throws IOException {
    return null;
  }

  @Override
  public FileSystem getFileSystem( URI uri ) {
    return null;
  }

  @Override
  public Path getPath( URI uri ) {
    return null;
  }

  @Override
  public SeekableByteChannel newByteChannel( Path path, Set< ? extends OpenOption > options, FileAttribute< ? >... attrs ) throws IOException {
    return null;
  }

  @Override
  public DirectoryStream< Path > newDirectoryStream( Path dir, Filter< ? super Path > filter ) throws IOException {
    return null;
  }

  @Override
  public void createDirectory( Path dir, FileAttribute< ? >... attrs ) throws IOException {

  }

  @Override
  public void delete( Path path ) throws IOException {

  }

  @Override
  public void copy( Path source, Path target, CopyOption... options ) throws IOException {

  }

  @Override
  public void move( Path source, Path target, CopyOption... options ) throws IOException {

  }

  @Override
  public boolean isSameFile( Path path, Path path2 ) throws IOException {
    return false;
  }

  @Override
  public boolean isHidden( Path path ) throws IOException {
    return false;
  }

  @Override
  public FileStore getFileStore( Path path ) throws IOException {
    return null;
  }

  @Override
  public void checkAccess( Path path, AccessMode... modes ) throws IOException {

  }

  @Override
  public < V extends FileAttributeView > V getFileAttributeView( Path path, Class< V > type, LinkOption... options ) {
    return null;
  }

  @Override
  public < A extends BasicFileAttributes > A readAttributes( Path path, Class< A > type, LinkOption... options ) throws IOException {
    return null;
  }

  @Override
  public Map< String, Object > readAttributes( Path path, String attributes, LinkOption... options ) throws IOException {
    return null;
  }

  @Override
  public void setAttribute( Path path, String attribute, Object value, LinkOption... options ) throws IOException {

  }

}
